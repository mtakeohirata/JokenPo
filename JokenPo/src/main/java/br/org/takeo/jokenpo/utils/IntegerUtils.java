package br.org.takeo.jokenpo.utils;

public abstract class IntegerUtils {

	public static boolean between(Integer valorComparado, Integer minimo, Integer maximo) {
		return valorComparado >= minimo && valorComparado <= maximo ? true: false;
	}
}
