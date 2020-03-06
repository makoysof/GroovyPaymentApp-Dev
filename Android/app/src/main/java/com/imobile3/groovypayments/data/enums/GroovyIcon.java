package com.imobile3.groovypayments.data.enums;

import com.imobile3.groovypayments.R;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;

public enum GroovyIcon {

    AlarmClock(1, R.drawable.ic_alarm_clock),
    BagCoins(2, R.drawable.ic_bag_coins),
    BatteryPack(3, R.drawable.ic_battery_pack),
    CeremonialMask(4, R.drawable.ic_ceremonial_mask),
    CoffeeMug(5, R.drawable.ic_coffee_mug),
    HammerNails(6, R.drawable.ic_hammer_nails),
    Lock(7, R.drawable.ic_lock),
    MoneyStack(8, R.drawable.ic_money_stack),
    OpenedFoodCan(9, R.drawable.ic_opened_food_can),
    Pencil(10, R.drawable.ic_pencil),
    Person(11, R.drawable.ic_person),
    PineTree(12, R.drawable.ic_pine_tree),
    RetroController(13, R.drawable.ic_retro_controller),
    Sandwich(14, R.drawable.ic_sandwich),
    ScrollUnfurled(15, R.drawable.ic_scroll_unfurled),
    Stopwatch(16, R.drawable.ic_stopwatch),
    Strongbox(17, R.drawable.ic_strongbox),
    TShirt(18, R.drawable.ic_t_shirt),
    Teapot(19, R.drawable.ic_teapot),
    WoodenChair(20, R.drawable.ic_wooden_chair),
    WrappedSweet(21, R.drawable.ic_wrapped_sweet);

    public final int id;
    @DrawableRes
    public final int drawableRes;

    GroovyIcon(int id, @DrawableRes int drawableRes) {
        this.id = id;
        this.drawableRes = drawableRes;
    }

    @NonNull
    public static GroovyIcon fromId(int id) {
        for (GroovyIcon value : values()) {
            if (value.id == id) {
                return value;
            }
        }
        return Person;
    }
}
