package com.example.demo.mapper;


import com.example.demo.common.Gear;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;


/**
 * @author Administrator
 */
@Mapper
public interface  GearMapper {


    @Select("select id,type,index_number as indexNumber, name,model, modulus,materials,heat_treatment as  heatTreatment, total_length as totalLength,head_count as headCount, gear_tooth_machining as  gearToothMachining , gear_precision as gearPrecision,  CONCAT('https://khkchilun.com/',img) as img, remarks  from t_gear")
    List<Gear> getAllGears();

    @Insert({"insert into t_gear(type,index_number,name,model,modulus,materials,heat_treatment,total_length,head_count,gear_tooth_machining,gear_precision, img, remarks) values(#{type},#{indexNumber},#{name},#{model},#{modulus},#{materials},#{heatTreatment},#{totalLength},#{headCount},#{gearToothMachining},#{gearPrecision},#{img},#{remarks})"})
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    Integer addGear(Gear gear);

    @Delete("delete from t_gear WHERE 1=1 ")
    int clearData();
}
