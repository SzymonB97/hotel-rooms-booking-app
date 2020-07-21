package pl.sborowy.hotelroomsbookingapp.util.customer;

public class CustomerMappings {

    // --private constants--
    private static final String CUSTOMERS_BASE_PATH = "/customers";

    // --public constants--
    public static final String CUSTOMERS_LIST = CUSTOMERS_BASE_PATH + "/list";
    public static final String CUSTOMER_GET = CUSTOMERS_BASE_PATH + "/get-customer";
    public static final String CUSTOMER_DELETE = CUSTOMERS_BASE_PATH + "/delete";
    public static final String CUSTOMER_FORM_SAVE = CUSTOMERS_BASE_PATH + "/form-save-customer";
    public static final String CUSTOMER_FORM_UPDATE = CUSTOMERS_BASE_PATH + "/form-update-customer";
    public static final String CUSTOMER_SAVE = CUSTOMERS_BASE_PATH + "/save";

    // --constructors--
    private CustomerMappings() {
    }
}
