package com.wubinben.kata.hotelworldclocks;


/**
 * RobotKeywordLibrary delegates all business logic to this facade at first. Then it is
 * the start of refactoring to Observer design pattern.
 * User: Ben
 * Date: 13-9-8
 * Time: 下午9:43
 * To change this template use File | Settings | File Templates.
 */
public class HotelWorldClocksFacade {
    private static final BenLogger LOGGER = BenLogger.getLogger(BenLogger.LEVEL_OFF);
    private TimeSubject timeSubject;

    public HotelWorldClocksFacade() {
    }

    public void testInitialization() {
        this.timeSubject = TimeSubject.newInstance();
    }

    /**
     * Todo: 在工厂类里用反射来创建实例，这样能消除重复代码。
     *  public CityFactory {
     public static CitiObserver create(String name) {
     Class clazz = class.forName(name);  //package info needed.
     CityObserver  city = clazz.newInstance();  //if so, remove newInstance() from every city.
     return city;
     }
     }
     * @param cityName
     * @param dstStatus
     */
    public void addACityWithDstStatus(String cityName, DaylightSavingTime dstStatus) {
        LOGGER.info("in HotelWorldClocksFacade.addACityWithDstStatus()");
        if (cityName.equals("Beijing")) {
            this.timeSubject.attach("Beijing", Beijing.newInstance(8, dstStatus, this.timeSubject));
            LOGGER.info("attached Beijing");
        }
        if (cityName.equals("London")) {
            this.timeSubject.attach("London", London.newInstance(0, dstStatus, this.timeSubject));
            LOGGER.info("attached London");
        }
        if (cityName.equals("Moscow")) {
            this.timeSubject.attach("Moscow", Moscow.newInstance(4, dstStatus, this.timeSubject));
            LOGGER.info("attached Moscow");
        }
        if (cityName.equals("Sydney")) {
            this.timeSubject.attach("Sydney", Sydney.newInstance(10, dstStatus, this.timeSubject));
            LOGGER.info("attached Sydney");
        }
        if (cityName.equals("New York")) {
            this.timeSubject.attach("New York", NewYork.newInstance(-5, dstStatus, this.timeSubject));
            LOGGER.info("attached New York");
        }
    }

    /**
     * Todo: 通过名称来处理会导致因为名称错误而引起不必要的Exception，可以通过Flyweight，Enum等来处理此事。新书7.5节对此有论述。
     * @param hour
     * @param cityName
     */
    public void adjustIncorrectTimeOfCity(int hour, String cityName) {
        LOGGER.info("in HotelWorldClocksFacade.adjustIncorrectTimeOfCity().");
        LOGGER.info("hour: " + hour);
        LOGGER.info("cityName: " + cityName);
        this.timeSubject.getCity(cityName).setTimeToTimeSubject(hour);
    }

    public String getResultHour(String cityName) {
        LOGGER.info("in HotelWorldClocksFacade.getResultHour().");
        LOGGER.info("201309111003 cityName: " + cityName + "this.timeSubject: " + this.timeSubject.toString());
        return this.timeSubject.getCity(cityName).getLocalHour();
    }

    public static HotelWorldClocksFacade newInstance() {
        return new HotelWorldClocksFacade();
    }

}
