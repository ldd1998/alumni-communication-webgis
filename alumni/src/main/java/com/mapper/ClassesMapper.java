package com.mapper;

import com.entity.Classes;

import java.util.List;

public interface ClassesMapper {

    List<Classes> queryClassesByPage(int page, int limit);

    List<Classes> queryClassesByClassNum(String classNum);

    Classes queryClassByClassId(int classId);

    boolean addFriends(String userid, String fuserid);
}
