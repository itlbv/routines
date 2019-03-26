package com.itlbv.routines;

import com.itlbv.routines.model.Role;
import com.itlbv.routines.model.User;

public class UserTestData {

    public static final int USER_01_ID = User.GLOBAL_SEQ;
    public static final int USER_02_ID = User.GLOBAL_SEQ + 1;

    public static final User USER_01 = new User("User1", "email1", "password1", Role.USER);
    public static final User USER_02 = new User("User2", "email2", "password2", Role.ADMIN);

    {
        USER_01.setId(USER_01_ID);
        USER_02.setId(USER_02_ID);
    }
}
