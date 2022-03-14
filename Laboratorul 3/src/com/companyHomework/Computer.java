package com.companyHomework;

public class Computer extends Node implements Identifiable, Storage{

    /**
     * This class is with inherited functions from Node class plus some extra traits, which are verified or computer with the custom interfaces
     */
        private String ip;
        private int data;

        Computer(String name, String location, String ip, int data) {
            super(name, location);
            this.ip = ip;
            this.data = data;
        }

        public boolean computeIdentifiable(){
            if(ip.isEmpty()){
                return false;
            }
            return true;
        }

        public String computeStorage(){
            return data + "GB";
        }

        public String getIp(){
            return ip;
        }

        public int getData(){
            return data;
        }

        public String toString(){
            return getName() + "(Computer " + getLocation() + ")";
        }

    }

