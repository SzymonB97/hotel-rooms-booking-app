package pl.sborowy.hotelroomsbookingapp.util.user;

public class UserMappings {

    // --private constants--
    private static final String USERS_BASE_PATH = "/users";

    // --public constants--
    public static final String USERS_LIST = USERS_BASE_PATH + "/list";
    public static final String USER_GET = USERS_BASE_PATH + "/get-user";
    public static final String USER_DELETE = USERS_BASE_PATH + "/delete";
    public static final String USER_FORM_SAVE = USERS_BASE_PATH + "/form-save-user";
    public static final String USER_FORM_UPDATE = USERS_BASE_PATH + "/form-update-user";
    public static final String USER_SAVE = USERS_BASE_PATH + "/save";

    // --constructors--
    private UserMappings() {
    }
}
