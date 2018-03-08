package com.xp.exe.jpaDemo.enums;

/**
 * Author:coderXp
 * Description: 规范返回信息
 * Date:Create in 2018/3/8 10:08
 * Modified By:
 */
public enum ClassInfoOptionalEnum {
    //定义允许返回的值
    OPTIONAL_SUCCESS{
        public String getInfo(){
            return "操作成功!";
        }
    },CLASS_INFO_EXIST{
        public String getInfo(){
            return "班级已存在";
        }
    },CLASS_INFO_NOT_EXIST{
        public String getInfo(){
            return "班级不存在";
        }
    },CLASS_INFO_ADD_FAIL{
        public String getInfo(){
            return "班级插入失败";
        }
    },CLASS_INFO_DEL_FAIL{
        public String getInfo(){
            return "班级删除失败";
        }
    },CLASS_INFO_MODIFY_FAIL{
        public String getInfo(){
            return "更新班级失败";
        }
    };

    //定义抽象方法
    public abstract  String getInfo();
}
