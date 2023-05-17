package com.example.demo.common;


import org.springframework.ui.Model;

/**
 * @author Administrator
 */
public class Gear {


    private Integer id;
    private Integer type;
    private Integer indexNumber;
    private String name;
    private String model;
    private String modulus;
    private String materials;
    private String heatTreatment;
    private String totalLength;
    private String headCount;
    private String gearToothMachining;
    private String gearPrecision;
    private String remarks;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(Integer indexNumber) {
        this.indexNumber = indexNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModulus() {
        return modulus;
    }

    public void setModulus(String modulus) {
        this.modulus = modulus;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public String getHeatTreatment() {
        return heatTreatment;
    }

    public void setHeatTreatment(String heatTreatment) {
        this.heatTreatment = heatTreatment;
    }

    public String getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(String totalLength) {
        this.totalLength = totalLength;
    }

    public String getHeadCount() {
        return headCount;
    }

    public void setHeadCount(String headCount) {
        this.headCount = headCount;
    }

    public String getGearToothMachining() {
        return gearToothMachining;
    }

    public void setGearToothMachining(String gearToothMachining) {
        this.gearToothMachining = gearToothMachining;
    }

    public String getGearPrecision() {
        return gearPrecision;
    }

    public void setGearPrecision(String gearPrecision) {
        this.gearPrecision = gearPrecision;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return "Gear{" +
                "id=" + id +
                ", type=" + type +
                ", indexNumber=" + indexNumber +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", modulus='" + modulus + '\'' +
                ", materials='" + materials + '\'' +
                ", heatTreatment='" + heatTreatment + '\'' +
                ", totalLength='" + totalLength + '\'' +
                ", headCount='" + headCount + '\'' +
                ", gearToothMachining='" + gearToothMachining + '\'' +
                ", gearPrecision='" + gearPrecision + '\'' +
                ", remarks='" + remarks + '\'' +
                '}';
    }
}
