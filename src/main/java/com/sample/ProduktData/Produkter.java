package com.sample.ProduktData;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

    public class Produkter implements Serializable {
        private transient SimpleStringProperty komponent;
        private transient SimpleStringProperty merke;
        private transient SimpleStringProperty type;
        private transient SimpleIntegerProperty pris;

        public Produkter() {
        }


        public Produkter(String type, String merke, int pris, String komponenet) {
            this.komponent = new SimpleStringProperty(komponenet);
            this.merke = new SimpleStringProperty(merke);
            this.type = new SimpleStringProperty(type);
            this.pris = new SimpleIntegerProperty(pris);
        }

        public String getKomponent() {
            return komponent.get();
        }

        public SimpleStringProperty komponentProperty() {
            return komponent;
        }

        public void setKomponent(String komponent) {
            this.komponent.set(komponent);
        }

        public String getMerke() {
            return merke.get();
        }

        public SimpleStringProperty merkeProperty() {
            return merke;
        }

        public void setMerke(String merke) {
            this.merke.set(merke);
        }

        public String getType() {
            return type.get();
        }

        public SimpleStringProperty typeProperty() {
            return type;
        }

        public void setType(String type) {
            this.type.set(type);
        }

        public int getPris() {
            return pris.get();
        }

        public SimpleIntegerProperty prisProperty() {
            return pris;
        }

        public void setPris(int pris) {
            if (pris < 0) {
                throw new IllegalArgumentException("Pris kan ikke være negativ");
            }
            this.pris.set(pris);
        }

        public String toString() {
            return "Produktet {" +
                    "komponent=" + komponent +
                    ",type=" + type +
                    ", merke=" + merke +
                    ", pris=" + pris +
                    '}';
        }

        private void writeObject(ObjectOutputStream s) throws IOException {
            s.defaultWriteObject();
            s.writeUTF(getKomponent());
            s.writeUTF(getType());
            s.writeUTF(getMerke());
            s.writeInt(getPris());

        }
        private void readObject(ObjectInputStream s) throws IOException, ClassNotFoundException {
            String komponenet = s.readUTF();
            String type = s.readUTF();
            String merke = s.readUTF();
            int pris = s.readInt();


            this.pris = new SimpleIntegerProperty(pris);
            this.merke = new SimpleStringProperty(merke);
            this.type = new SimpleStringProperty(type);
            this.komponent = new SimpleStringProperty(komponenet);

        }

        public static double totalpris  (ObservableList<Produkter> produkt){
            double totalprisen = 0;
            for (Produkter etprodukt : produkt){
                totalprisen += etprodukt.getPris();
            }
            return totalprisen;
        }


    }