package com.example.cypher;


public class Prueba {
	public static void main(String[] args) {
		String texto="hola mundo";
		String textoEncriptado =EncrypUtil.encrypt(texto);
		System.out.println("texto encriptado:"+ textoEncriptado);
		String textoPlano =EncrypUtil.desencrypt(textoEncriptado);
		System.out.println("texto plano:"+ textoPlano);

	}

}
