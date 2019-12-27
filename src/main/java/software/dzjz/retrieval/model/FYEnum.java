package software.dzjz.retrieval.model;

import software.dzjz.retrieval.util.StringUtil;

import java.util.HashMap;
import java.util.Map;

public enum FYEnum {
    TJGY("天津市高级人民法院","市高级法院","120000 200","130.1.1.111","51", 1,"高院"),
    TJYZY("天津市第一中级人民法院","第一中级法院","120100 210","130.2.0.110","52", 2,"一中院"),
    TJEZY("天津市第二中级人民法院","第二中级法院","120200 220","130.3.100.36","62", 3,"二中院"),
    TJHS("天津海事法院","海事法院","960200 230","130.4.1.196","72", 4,"海事"),
    TJBH("天津滨海法院","滨海新区法院","120242 22A","130.25.1.13","74", 5,"滨海新区"),
    TJHP("天津市和平区人民法院","和平区法院","120101 211","130.6.0.200","53", 6,"和平区"),
    TJHD("天津市河东区人民法院","河东区法院","120202 221","130.9.40.13","63", 7,"河东区"),
    TJHX("天津市河西区人民法院","河西区法院","120203 222","130.10.0.167","64", 8,"河西区"),
    TJHB("天津市河北区人民法院","河北区法院","120105 213","130.7.0.7","55", 9,"河北区"),
    TJNK("天津市南开区人民法院","南开区法院","120104 212","130.5.0.14","54", 10,"南开区"),
    TJHQ("天津市红桥区人民法院","红桥区法院","120106 214","130.8.0.73","56", 11,"红桥区"),
    TJDL("天津市东丽区人民法院","东丽区法院","120207 226","130.13.0.13","68", 12,"东丽区"),
    TJXQ("天津市西青区人民法院","西青区法院","120107 215","130.11.1.5","57", 13,"西青区"),
    TJJN("天津市津南区人民法院","津南区法院","120208 227","130.14.0.22","69", 14,"津南区"),
    TJBC("天津市北辰区人民法院","北辰区法院","120108 216","130.12.0.2","58",15,"北辰区"),
    TJWQ("天津市武清区人民法院","武清区法院","120222 217","130.19.0.12","59", 16,"武清区"),
    TJBD("天津市宝坻区人民法院","宝坻区法院","120224 219","130.21.0.5","61", 17,"宝坻区"),
    TJJH("天津市静海区人民法院","静海区法院","120223 218","130.20.1.8","60", 18,"静海区"),
    TJNH("宁河区人民法院","宁河区法院","120221 228","130.18.0.11","70", 19,"宁河区"),
    JX("天津市蓟州区人民法院","蓟州法院","120225 21A","130.22.0.8","73", 20,"蓟州区"),
    TJTG("天津市塘沽区人民法院","塘沽审判区","120204 223","130.15.0.21","65", 21,"塘沽区"),
    TJHG("天津市汉沽区人民法院","汉沽审判区","120205 224","130.16.0.18","66", 22,"汉沽区"),
    TJDG("天津市大港区人民法院","大港审判区","120206 225","130.17.0.12","67", 23,"大港区"),
    TJKFQ("天津市经济技术开发区人民法院","功能区审判区","120241 229","130.23.0.15","71", 24,"功能区"),
    TJTL("天津铁路运输法院","铁路法院","920103 132","130.26.0.7","24", 25,"铁路"),
    TJGYCS("测试","测试","120000 100","","-1",26,"测试")
    ;

    String name;

    String jc;

    String fydm;

    String fydz;

    String fybh;

    Integer index;
    /**
     * 修改人：xxy
     * Created at 14:16 2018/10/19
     * 增加地区名称为标准化首页数据
     */
    String dqmc;


    private FYEnum(String name, String jc, String fydm) {
        this.name = name;
        this.jc = jc;
        this.fydm = fydm;
    }


    private FYEnum(String name, String jc, String fydm, String fydz, String fybh) {
        this.name = name;
        this.jc = jc;
        this.fydm = fydm;
        this.fydz = fydz;
        this.fybh = fybh;
    }

    private FYEnum(String name, String jc, String fydm, String fydz, String fybh, Integer index) {
        this.name = name;
        this.jc = jc;
        this.fydm = fydm;
        this.fydz = fydz;
        this.fybh = fybh;
        this.index = index;
    }

    private FYEnum(String name, String jc, String fydm, String fydz, String fybh, Integer index, String dqmc) {
        this.name = name;
        this.jc = jc;
        this.fydm = fydm;
        this.fydz = fydz;
        this.fybh = fybh;
        this.index = index;
        this.dqmc = dqmc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJc() {
        return jc;
    }

    public void setJc(String jc) {
        this.jc = jc;
    }

    public String getFydm() {
        return fydm;
    }

    public void setFydm(String fydm) {
        this.fydm = fydm;
    }

    public String getFydz() {
        return fydz;
    }

    public void setFydz(String fydz) {
        this.fydz = fydz;
    }

    public String getFybh() {
        return fybh;
    }

    public void setFybh(String fybh) {
        this.fybh = fybh;
    }

    public String getDqmc() {
        return dqmc;
    }

    public void setDqmc(String dqmc) {
        this.dqmc = dqmc;
    }

    public static FYEnum getEnumByfydm(String fydm){
        for(FYEnum fy:FYEnum.values()){
            if(StringUtil.equals(fy.getFydm(), fydm)){
                return fy;
            }
        }
        return null;
    }


    public static FYEnum getEnumByfybh(String fybh){
        for(FYEnum fy:FYEnum.values()){
            if(StringUtil.equals(fy.getFybh(), fybh)){
                return fy;
            }
        }
        return null;
    }

    public static FYEnum getEnumByAccessIp(String ip){
        String[] list = ip.split("\\.");
        if(list == null || list.length != 4){
            return null;
        }
        String temp = list[0]+"."+list[1];
        for(FYEnum fy:FYEnum.values()){
            if(fy.getFydz().contains(temp)){
                return fy;
            }
        }
        return null;
    }

    public static String getFybhByfydm(String fydm){
        for(FYEnum fy:FYEnum.values()){
            if(StringUtil.equals(fy.getFydm(), fydm)){
                return fy.getFybh();
            }
        }
        return null;
    }

    public static String getFydmByfybh(String fybh){
        for(FYEnum fy:FYEnum.values()){
            if(StringUtil.equals(fy.getFybh(), fybh)){
                return fy.getFydm();
            }
        }
        return null;
    }

    public static String getFyjcByfydm(String fydm){
        if(fydm == null){
            return null;
        }
        for(FYEnum fy:FYEnum.values()){
            if(StringUtil.equals(fy.getFydm(), fydm)){
                return fy.getJc();
            }
        }
        return null;
    }

    public static String getFyjcByfybh(String fybh){
        if(fybh == null){
            return null;
        }
        for(FYEnum fy:FYEnum.values()){
            if(StringUtil.equals(fy.getFybh(), fybh)){
                return fy.getJc();
            }
        }
        return null;
    }

    public static String getFYDMByName(String name) {
        for(FYEnum fy:FYEnum.values()){
            if(fy.getName().contains(name))
                return fy.getFydm();
        }
        return null;
    }

    public static String getNameByFYDM(String fydm) {
        for(FYEnum fy:FYEnum.values()){
            if(fy.getFydm().equals(fydm))
                return fy.getName();
        }
        return null;
    }

    public static String getFymcByfydm(String fydm) {
        for(FYEnum fy:FYEnum.values()){
            if(fy.getFydm().equals(fydm))
                return fy.getName();
        }
        return null;
    }

    public static String getFymcByfybh(Integer fybh) {
        for(FYEnum fy:FYEnum.values()){
            if(fy.getFybh().equals(fybh.toString()))
                return fy.getName();
        }
        return null;
    }

    public static Map<String, String> getFyMap() {
        Map<String, String> map = new HashMap<String, String>();
        for(FYEnum fy:FYEnum.values()){
            map.put(fy.getFydm(), fy.getName());
        }
        return map;
    }

    public static FYEnum getSjFy(String fydm){ //获得上级法院
        if(fydm.equals("120000 200"))
            return null ;
        else if(fydm.equals("120100 210")||fydm.equals("120200 220"))
            return TJGY ;
        else if(fydm.charAt(8)=='1')
            return TJYZY ;
        else
            return TJEZY ;
    }

    public Integer getIndex() {
        return index;
    }
}

