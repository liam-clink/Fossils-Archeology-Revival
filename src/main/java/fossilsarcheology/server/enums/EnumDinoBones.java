package fossilsarcheology.server.enums;

public enum EnumDinoBones {
    Triceratops, Velociraptor, Tyrannosaurus, Pterosaur, Plesiosaur, Mosasaurus, Stegosaurus, Dilophosaurus, Brachiosaurus, Spinosaurus, Compsognathus, Ankylosaurus, Pachycephalosaurus, Deinonychus, Gallimimus, Liopleurodon, Allosaurus, Sarcosuchus, Ceratosaurus, Confuciusornis, Dodo, Gastornis, Kelenken, Phorusrhacos, Titanis, Mammoth, Smilodon, Quagga, Elasmotherium;
    
    public static EnumDinoBones get(EnumPrehistoric prehistoric){
    	for(EnumDinoBones bones : EnumDinoBones.values()){
    		if(bones.name().equals(prehistoric.name())){
    			return bones;
    		}
    	}
		return null;
    }
}
