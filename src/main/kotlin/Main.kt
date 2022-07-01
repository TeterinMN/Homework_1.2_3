/**
 * Схема достаточно простая: чем большую сумму потратил пользователь, тем большую скидку вы ему даёте.
 * Условия следующие:
 * Если сумма покупки от 0 до 1 000 рублей, то никаких скидок нет (как в лекции).
 * Если сумма покупки от 1 001 до 10 000 рублей, то стандартная скидка - 100 рублей (как в лекции).
 * Если сумма покупки от 10 001 рубль и выше то % составляет 5% от суммы.
 * Все цены указаны в рублях.
 *
 * При этом постоянные пользователи — те, кто покупает ежемесячно, назовём их «меломаны», дополнительно
 * получают 1% скидки сверху.
 *
 * Важно: скидки не суммируются, а применяются сверху. Например, у пользователя скидка 5%,
 * значит 1% применяется к 95%
 */

fun main() {
    val money = 11000
    val musicLover = true
    var totalPrice: Double
    val discountMin = 100
    val discountMax = 0.05
    val discountMusicLover = 0.01


    println("Стоимость заказа: $money руб.")

    if (money in 1001..10_000) {
        totalPrice = money - discountMin.toDouble()
        println("Стандартная скидка:  $discountMin руб.! -  $totalPrice руб.")
    } else if (money > 10_000) {
        totalPrice = money - (money * discountMax)
        println("Увеличенная скидка 5%: $totalPrice руб.")
    } else {
        totalPrice = money.toDouble()
        println("Скидки нет: $money руб.")
    }
    if (musicLover) {
        totalPrice -= totalPrice * discountMusicLover
        println("Меломану дополнительная скидка 1%: $totalPrice руб.")
    }
}