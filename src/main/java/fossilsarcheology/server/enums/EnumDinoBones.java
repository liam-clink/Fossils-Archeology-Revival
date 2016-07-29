package fossilsarcheology.server.enums;

public enum EnumDinoBones {
    Triceratops, Velociraptor, Tyrannosaurus, Pterosaur, Plesiosaur, Mosasaurus, Stegosaurus, Dilophosaurus, Brachiosaurus, Spinosaurus, Compsognathus, Ankylosaurus, Pachycephalosaurus, Deinonychus, Gallimimus, Liopleurodon, Allosaurus, Sarcosuchus, Ceratosaurus, Dryosaurus, Therizinosaurus, Parasaurolophus, Confuciusornis, Icthyosaurus, Henodus, Dodo, Gastornis, Kelenken, Phorusrhacos, Titanis, Mammoth, Smilodon, Quagga, Elasmotherium;

    public static EnumDinoBones get(EnumPrehistoric prehistoric) {
	for (EnumDinoBones bones : EnumDinoBones.values()) {
	    if (bones.name().toLowerCase().equals(prehistoric.name().toLowerCase())) {
		return bones;
	    }
	}
	return null;
    }

    public static EnumPrehistoric from(EnumDinoBones bone) {
	for (EnumPrehistoric prehistorics : EnumPrehistoric.values()) {
	    if (prehistorics.name().equals(bone.name())) {
		return prehistorics;
	    }
	}
	return null;
    }
}
