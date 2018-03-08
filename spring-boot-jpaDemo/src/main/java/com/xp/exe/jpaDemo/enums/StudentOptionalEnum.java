package com.xp.exe.jpaDemo.enums;

/**
 * Author:coderXp
 * Description: 规范返回信息
 * Date:Create in 2018/3/8 10:08
 * Modified By:
 */
public enum StudentOptionalEnum {
    //定义允许返回的值
    OPTIONAL_SUCCESS{
        public String getInfo(){
            return "操作成功!";
        }
    },STUDENT_EXIST{
        public String getInfo(){
            return "学生已存在";
        }
    },STUDENT_NOT_EXIST{
        public String getInfo(){
            return "学生不存在";
        }
    },STUDENT_ADD_FAIL{
        public String getInfo(){
            return "学生信息插入失败";
        }
    },STUDENT_DEL_FAIL{
        public String getInfo(){
            return "学生删除失败";
        }
    },STUDENT_MODIFY_FAIL{
        public String getInfo(){
            return "更新学生信息失败";
        }
    };

    //定义抽象方法
    public abstract  String getInfo();
}
