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
    val itemPrise = 100
    val itemCount = 301
    val discountStart = 1001
    val discountLarge = 10_000
    var totalPrise = itemPrise * itemCount

    if (totalPrise in (discountStart + 1) until discountLarge) {
        println(
            "Стоимость одной композиции = 100 руб. \nМы покупаем $itemCount композиций на сумму $totalPrise руб. " +
                    "и получаем скидку в 100 руб."
        )
        totalPrise -= 100
        println("Итого: $totalPrise рублей")
    } else if (totalPrise > discountLarge && itemCount < 300) {
        val discount = (totalPrise * 5) / 100
        println(
            "Стоимость одной композиции = 100 руб. \nМы покупаем $itemCount композиций на сумму $totalPrise руб. " +
                    "и получаем скидку в 5%"
        )
        totalPrise -= discount
        println("Итого: $totalPrise рублей c учетом скидки в 5%")
    } else if (itemCount >= 300) {
        val discount = (totalPrise * 5) / 100
        println(
            "Стоимость одной композиции = 100 руб. \nМы покупаем $itemCount композиций на сумму $totalPrise руб. " +
                    "и получаем скидку в 5%, а так же 1% как постоянному покупателю"
        )
        totalPrise -= discount
        val discount2: Double = ((totalPrise * 1) / 100).toDouble()
        val res: Double = totalPrise - discount2
        println("Итого: $res рублей c учетом скидки в 5% и 1%")
    } else {
        println(
            "Стоимость одной композиции = 100 руб. \nМы покупаем $itemCount композиций на сумму $totalPrise руб. " +
                    "СКИДОК НЕТ"
        )
    }

}