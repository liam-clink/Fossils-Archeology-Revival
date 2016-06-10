package com.github.revival.server.entity;

public enum EnumDiet {
	CARNIVORE(3), HERBIVORE(0), OMNIVORE(1), PISCIVORE(1), CARNIVORE_EGG(2), INSECTIVORE(0), PISCCARNIVORE(3), NONE(0);

	public int fearIndex;

	EnumDiet(int fearIndex) {
		this.fearIndex = fearIndex;
	}
}
