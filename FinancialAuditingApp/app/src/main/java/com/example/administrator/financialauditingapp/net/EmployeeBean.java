package com.example.administrator.financialauditingapp.net;

import android.text.TextUtils;

import com.google.gson.annotations.SerializedName;

import java.util.List;

//雇员实体
public class EmployeeBean {
    /// <summary>
    /// 雇员id
    /// </summary>
    @SerializedName("id")
    public String id;

    /// <summary>
    /// 雇员编号
    /// </summary>
    @SerializedName("employeecode")
    public String employeecode;

    /// <summary>
    /// 手机号码
    /// </summary>
    @SerializedName("mobile")
    public String mobile;

    /// <summary>
    /// 登录名
    /// </summary>
    @SerializedName("logonname")
    public String logonname;

    /// <summary>
    /// 登录密码
    /// </summary>
    @SerializedName("password")
    public String password;

    /// <summary>
    /// 加密方式
    /// </summary>
    @SerializedName("passwordformat")
    public int passwordformat;

    /// <summary>
    /// 邮箱地址
    /// </summary>
    @SerializedName("email")
    public String email;

    /// <summary>
    /// 真实姓名
    /// </summary>
    @SerializedName("realname")
    public String realname;

    /// <summary>
    /// 角色id
    /// </summary>
    @SerializedName("roleid")
    public String roleid;

    /// <summary>
    /// 角色名称
    /// </summary>
    @SerializedName("rolename")
    public String rolename;

    /// <summary>
    /// 所负责的城市id列表
    /// </summary>
    @SerializedName("responsiblecity")
    public List<City> responsiblecity;
    /**
     * 权限列表
     */
    @SerializedName("permissions")
    public List<String> permissions;

    @SerializedName("isdesigner")
    public boolean isdesigner;

    /**
     * iscitymanager : false
     * isgroupleader : false
     * issigndesigner : false
     * issubsitedesiger : false
     * responsibledesigners : null
     */

    @SerializedName("iscitymanager")
    public boolean iscitymanager;
    @SerializedName("isgroupleader")
    public boolean isgroupleader;
    @SerializedName("issigndesigner")
    public boolean issigndesigner;
    @SerializedName("issubsitedesiger")
    public boolean issubsitedesiger;
    @SerializedName("responsibledesigners")
    public Object responsibledesigners;
    /**
     * groupid : 0
     * groupmenus : [{"badge":"","code":"0563","name":"财务预算审核(app)"}]
     */

    @SerializedName("menus")
    public List<MenusBean> menus;

    public static class MenusBean {
        @SerializedName("groupid")
        public int groupid;
        /**
         * badge :
         * code : 0563
         * name : 财务预算审核(app)
         */

        @SerializedName("groupmenus")
        public List<GroupmenusBean> groupmenus;

        public static class GroupmenusBean {
            @SerializedName("badge")
            public String badge;
            @SerializedName("code")
            public String code;
            @SerializedName("name")
            public String name;

            public GroupmenusBean() {
            }

            public GroupmenusBean(String code) {
                this.code = code;
            }

            public GroupmenusBean(String badge, String code, String name) {
                this.badge = badge;
                this.code = code;
                this.name = name;
            }

            public int getBadge() {
                if (TextUtils.isEmpty(badge)) return 0;
                if (badge.matches("[0-9]{1,}")) {
                    return Integer.parseInt(badge);
                } else return 0;
            }

            @Override
            public boolean equals(Object o) {
                if (o == null) return false;
                if (!(o instanceof GroupmenusBean)) return false;
                GroupmenusBean menu = (GroupmenusBean) o;
                if (code == null) {
                    return menu.code == null;
                }
                return code.equals(menu.code);
            }
        }
    }
}
