package dynamicProxy.staticProxy;

/**
 * Created by victor on 16/2/4.
 */
public class StaticProxyTest {
    public static void main(String[] args) {
        Station s = new Station();
        TicketService service = new StationProxy(s);
        service.inquire();
    }
}
