package com.itlbv.routines;

import com.itlbv.routines.model.Routine;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class RoutineTestData {
    public static final int ROUTINE_01_ID = UserTestData.USER_02.getId() + 1;
    public static final int ROUTINE_02_ID = ROUTINE_01_ID + 1;
    public static final int ROUTINE_03_ID = ROUTINE_02_ID + 1;
    public static final int ROUTINE_04_ID = ROUTINE_03_ID + 1;

    public static final Routine ROUTINE_01 = new Routine("Name1", "Description1", LocalDateTime.of(2001, 01, 01, 0, 0), LocalDateTime.of(2001, 01, 02, 0, 0), LocalTime.of(11, 0));
    public static final Routine ROUTINE_02 = new Routine("Name2", "Description2", LocalDateTime.of(2001, 01, 01, 0, 0), LocalDateTime.of(2001, 01, 02, 0, 0), LocalTime.of(11, 0));
    public static final Routine ROUTINE_03 = new Routine("Name3", "Description3", LocalDateTime.of(2001, 01, 01, 0, 0), LocalDateTime.of(2001, 01, 02, 0, 0), LocalTime.of(11, 0));
    public static final Routine ROUTINE_04 = new Routine("Name4", "Description4", LocalDateTime.of(2001, 01, 01, 0, 0), LocalDateTime.of(2001, 01, 02, 0, 0), LocalTime.of(11, 0));

    {
        ROUTINE_01.setId(ROUTINE_01_ID);
        ROUTINE_02.setId(ROUTINE_02_ID);
        ROUTINE_03.setId(ROUTINE_03_ID);
        ROUTINE_04.setId(ROUTINE_04_ID);
    }
}
