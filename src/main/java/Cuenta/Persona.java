package Cuenta;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author SUSANA
 */
public class Persona {

   private String nombre;
   private byte edad;
   private String dni;
   private char sexo;
   private float altura;
   private float peso;
   public static final int PESOIDEAL=0;
   public static final int BAJOPESO=-1;
   public static final int SOBREPESO=1;
   Persona(){
       //this("",0,'H',0f,0f);
        this.nombre = "";
        this.edad=0;
        this.dni=generaDni();
        this.sexo='H';
        this.altura=0f;
        this.peso=0f;
   }
   Persona(String nombre, byte edad, char sexo){
        this(nombre, edad, sexo,0f,0f);
   }
     Persona(String nombre, byte edad, char sexo,float altura, float peso){
        this.nombre = nombre;
        this.edad=edad;
        this.dni=generaDni();
        comprobarSexo(sexo); //comprueba si el carácter introducido es correcto ('M' o 'S')
        this.altura=altura;
        this.peso=peso;
   }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the edad
     */
    public byte getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(byte edad) {
        this.edad = edad;
    }

    /**
     * @return the dni
     */
    public String getDni() {
        return dni;
    }

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the altura
     */
    public float getAltura() {
        return altura;
    }

    /**
     * @param altura the altura to set
     */
    public void setAltura(float altura) {
        this.altura = altura;
    }

    /**
     * @return the peso
     */
    public float getPeso() {
        return peso;
    }

    /**
     * @param peso the peso to set
     */
    public void setPeso(float peso) {
        this.peso = peso;
    }
   @Override
    public String toString(){
        String datos= "\nNombre "+nombre+"\n";
        datos+=" edad "+edad+"\n";
        datos+=" DNI "+dni+"\n";
        datos+=" sexo "+sexo+"\n";
        datos+=" peso "+peso+" altura "+altura;
        return datos;
    }
    public int calcularIMC(){
        double imc = this.peso/(Math.pow(this.altura, 2));
        if(imc<20) return BAJOPESO;
        else if (imc>=20 || imc<=25) return PESOIDEAL;
        else return SOBREPESO;
    }
    public boolean esMayorDeEdad(){
        return (this.edad>=18); //Devuelve true si es mayor de edad y false si no;
    }
    private void comprobarSexo(char sexo){
        if(Character.toUpperCase(sexo)=='H' ||Character.toUpperCase(sexo)=='M')
            this.sexo = sexo;
        else this.sexo='H';
    }
    private String generaDni(){
        char letras[] = {'T', 'R', 'W', 'A', 'G', 'M', 'Y',
            'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z',
            'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
        String sDni="";
        int resto;
        for(int i=0;i<8;i++){
            sDni += (char)(Math.random()*(57-48+1)+48);
        }
        Integer iDni = Integer.parseInt(sDni);
        resto = iDni % 23;
        sDni+=letras[resto];
        return sDni;
    }
}
