package com.java.programs.javaeight.dto;

import java.util.ArrayList;
import java.util.List;

public class Service {
    static List<CSDto> csDtoList;
    static List<ECDto> ecDtoList;
    static List<InstituteDto> instituteDtoList = new ArrayList<>();

    static {
        //cs student list
        csDtoList = new ArrayList<>();
        CSDto csDto = new CSDto("Adil Khan", "1");
        CSDto csDto1 = new CSDto("Aditya", "2");
        CSDto csDto2 = new CSDto("Akshat", "3");

        csDtoList.add(csDto);
        csDtoList.add(csDto1);
        csDtoList.add(csDto2);

        //ec student list
        ecDtoList = new ArrayList<>();

        ECDto ecDto = new ECDto("Ajay", "1");
        ECDto ecDto1 = new ECDto("Keshav", "2");

        ecDtoList.add(ecDto);
        ecDtoList.add(ecDto1);


    }

    public static void main(String[] args) {

        System.out.println("cs list " + csDtoList);
        System.out.println("ec list " + ecDtoList);


        csDtoList.stream().forEach(
                csDtoData -> ecDtoList.stream().filter(
                        ecDtoData -> csDtoData.getCsStudentId().equals(ecDtoData.getEcStudentId())
                ).forEach(
                        data -> instituteDtoList.add(new InstituteDto(data.getEcStudentName(), data.getEcStudentId()))
                )
        );

        System.out.println("institute ls " + instituteDtoList);

        csDtoList.stream().forEach(
                csDto -> ecDtoList.stream().filter(
                        ecDto -> csDto.getCsStudentId().equals(ecDto.getEcStudentId())
                ).forEach(
                        data -> instituteDtoList.add(new InstituteDto(csDto.getCsStudentName(),csDto.getCsStudentId()))
                )
        );
        System.out.println("new institute ls " + instituteDtoList);

        csDtoList.stream().forEach(
                csDto -> ecDtoList.stream().forEach(
                        ecDto -> instituteDtoList.add(new InstituteDto(ecDto.getEcStudentName(),ecDto.getEcStudentId()))
                )
        );

        System.out.println("new institute ls 1 " + instituteDtoList);



    }
}
