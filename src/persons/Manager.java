package persons;

import car_components.ModelsParameters;
import car_types.Car;
import factory.Conveyor;
import report.Report;
import warehouse.Warehouse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class Manager {
    private static final int COMPARE_EQUAL_VALUE = 0;
    private static final String FILE_NAME_POSTFIX = "Report.txt";
    private static final String RESULT_MESSAGE = "ИТОГ:";
    private static final String INCOME_MESSAGE = "Доходы: ";
    private static final String EXPENSES_MESSAGE = "Расходы: ";
    private static final String PROFIT_MESSAGE = "Прибыль: ";
    private static final String MANAGER_NAME = "Имя менеджера: " ;
    private static final String REGEX = "%-20s";
    private static final String REGEX_HEADER = "%-20s%-20s%-20s";
    private static final String MODEL_MESSAGE = "Модель: ";
    private static final String PRICE_MESSAGE = "Стоимость продажи: ";
    private static final String COST_MESSAGE = "Себестоимость: ";
    private static final BigDecimal PRODUCTION_MARGIN_MULTIPLIER = BigDecimal.valueOf(0.1);

    private Warehouse warehouse;
    private Conveyor conveyor;
    private String name;
    private Report report;

    public Manager(Warehouse warehouse, Conveyor conveyor, String name) {
        this.warehouse = warehouse;
        this.conveyor = conveyor;
        this.name = name;
        report = new Report(name);
    }

    /**
     * проверка, хватает ли денег на что-либо
     */
    private static boolean isEnoughMoney(BigDecimal buyerMoney) {
        for (ModelsParameters modelsParameters : ModelsParameters.values()) {
            if (buyerMoney.compareTo(modelsParameters.getPrice()) >= COMPARE_EQUAL_VALUE) {
                return true;
            }
        }
        return false;
    }

    /**
     * проверка, хватает ли на заказ с производства
     */
    private boolean isEnoughMoneyToOrderFromFactory(BigDecimal buyerMoney, BigDecimal carPriceWithMargin) {
        return buyerMoney.compareTo(carPriceWithMargin) >= COMPARE_EQUAL_VALUE;
    }

    public Car sellCar(Buyer buyer) {
        BigDecimal buyerMoney = buyer.getAmountOfMoney();
        if (!isEnoughMoney(buyerMoney)) {
            return null;
        }
        Car selectedCar = findCarToSell(buyer);
        if (selectedCar != null) {
            buyer.substractMoney(selectedCar.getCarPrice());
            buyer.setCar(selectedCar);
            updateReport(selectedCar);
        }
        return selectedCar;
    }

    /**
     * поиск самой дорогой машины по карману
     */
    private Car findCarToSell(Buyer buyer) {
        BigDecimal buyerMoney = buyer.getAmountOfMoney();
        for (int i = ModelsParameters.values().length - 1; i >= 0; i--) {
            BigDecimal priceWithMargin = countCarPriceWithMargin(ModelsParameters.values()[i].getPrice());
            if (buyerMoney.compareTo(ModelsParameters.values()[i].getPrice()) < COMPARE_EQUAL_VALUE) {
                continue;
            }
            if (warehouse.showModelQuantity(ModelsParameters.values()[i].getCarModel()) > COMPARE_EQUAL_VALUE) {
                return warehouse.takeCar(ModelsParameters.values()[i].getCarModel());
            } else {
                if (isEnoughMoneyToOrderFromFactory(buyerMoney, priceWithMargin)) {
                    warehouse.addCar(conveyor.createCarFromRequest(ModelsParameters.values()[i].getCarModel(),
                            ModelsParameters.values()[i].getStandartColor(), priceWithMargin));
                    return warehouse.takeCar(ModelsParameters.values()[i].getCarModel());
                    }
            }
        }
        return null;
    }

    public void generateReport() {
        File file = new File(getName() + FILE_NAME_POSTFIX);
        try (PrintWriter printWriter = new PrintWriter(file)) {
           printTable(printWriter);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * печать и форматирование репорта в таблицу
     */
    private void printTable(PrintWriter printWriter){
        printWriter.printf(REGEX, MANAGER_NAME + report.getName());
        printWriter.println();
        printWriter.printf(REGEX_HEADER, MODEL_MESSAGE, PRICE_MESSAGE, COST_MESSAGE);
        printWriter.println();
        for (Car car : report.getSoldCars()) {
            printWriter.printf(REGEX, car.getModel());
            printWriter.printf(REGEX, car.getCarPrice());
            printWriter.printf(REGEX, ModelsParameters.valueOf(car.getModel().toUpperCase()).getCostPrice());
            printWriter.println();
        }
        printWriter.println();
        printWriter.println(RESULT_MESSAGE);
        printWriter.println(INCOME_MESSAGE + report.countIncome());
        printWriter.println(EXPENSES_MESSAGE + report.countExpenses());
        printWriter.println(PROFIT_MESSAGE + report.countProfit());
    }

    private void updateReport(Car car) {
        report.addCar(car);
    }

    private BigDecimal countCarPriceWithMargin (BigDecimal oldPrice) {
        BigDecimal percent = oldPrice.multiply(PRODUCTION_MARGIN_MULTIPLIER);
        return oldPrice.add(percent);
    }

    public String getName() {
        return name;
    }
}
