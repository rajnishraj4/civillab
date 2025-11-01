package com.tech.adira.app.management.civillab.constants.item;

public enum UnitGroup {
    MASS(MassUnit.class),
    VOLUME(VolumeUnit.class),
    LENGTH(LengthUnit.class),
    TIME(TimeUnit.class);

    private final Class<? extends Enum<?>> unitEnum;

    UnitGroup(Class<? extends Enum<?>> unitEnum) {
        this.unitEnum = unitEnum;
    }

    public Enum<?>[] getUnits() {
        return unitEnum.getEnumConstants();
    }

    public enum MassUnit {
        KILOGRAM, GRAM, TONNE, POUND, OUNCE
    }

    public enum VolumeUnit {
        LITRE, MILLILITRE, CUBIC_METER, GALLON
    }

    public enum LengthUnit {
        METER, CENTIMETER, KILOMETER, INCH, FOOT, MILE
    }

    public enum TimeUnit {
        SECOND, MINUTE, HOUR, DAY, YEAR
    }
}
