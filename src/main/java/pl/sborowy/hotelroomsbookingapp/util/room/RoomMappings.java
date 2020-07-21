package pl.sborowy.hotelroomsbookingapp.util.room;

public class RoomMappings {

    // --private constants--
    private static final String ROOMS_BASE_PATH = "/rooms";

    // --public constants--
    public static final String ROOMS_LIST = ROOMS_BASE_PATH + "/list";
    public static final String ROOM_GET = ROOMS_BASE_PATH + "/get-room";
    public static final String ROOM_DELETE = ROOMS_BASE_PATH + "/delete";
    public static final String ROOM_SAVE = ROOMS_BASE_PATH + "/save";
    public static final String ROOM_FORM_SAVE = ROOMS_BASE_PATH + "/form-save-room";
    public static final String ROOM_FORM_UPDATE = ROOMS_BASE_PATH + "/form-update-room";

    // --constructors--
    private RoomMappings() {
    }
}
