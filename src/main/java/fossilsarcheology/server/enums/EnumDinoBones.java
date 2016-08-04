package fossilsarcheology.server.enums;

public enum EnumDinoBones {
    Triceratops, Velociraptor, Tyrannosaurus, Pterosaur, Plesiosaur, Mosasaurus, Stegosaurus, Dilophosaurus, Brachiosaurus, Spinosaurus, Compsognathus, Ankylosaurus, Pachycephalosaurus, Deinonychus, Gallimimus, Liopleurodon, Allosaurus, Sarcosuchus, Ceratosaurus, Confuciusornis, Dodo, Gastornis, Kelenken, Phorusrhacos, Titanis, Mammoth, Smilodon, Quagga, Elasmotherium;

    public static EnumDinoBones get(PrehistoricEntityType prehistoric) {
        for (EnumDinoBones bones : EnumDinoBones.values()) {
            if (bones.name().toLowerCase().equals(prehistoric.name().toLowerCase())) {
                return bones;
            }
        }
        return null;
    }

    public static PrehistoricEntityType from(EnumDinoBones bone) {
        for (PrehistoricEntityType prehistorics : PrehistoricEntityType.values()) {
            if (prehistorics.name().equals(bone.name())) {
                return prehistorics;
            }
        }
        return null;
    }
}
