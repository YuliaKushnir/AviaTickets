// ==========Змінні для блока right-wrapper==========

// Оголошення змінної trevelerNumberVeriable
var trevelerNumberVeriable = "1";
document.querySelector('.right-wrapper__treveler-number-veriable').textContent = trevelerNumberVeriable;

// Оголошення змінної trevelerAdultVeriable
var trevelerAdultVeriable = "Adult";
document.querySelector('.right-wrapper__treveler-adult-veriable').textContent = trevelerAdultVeriable;

// Оголошення змінної trevelerPriceVeriable
// var trevelerPriceVeriable = "$58.48";
// document.querySelector('.right-wrapper__treveler-price-variable').textContent = trevelerPriceVeriable;

// Оголошення змінної flightPriceVeriable
// var flightPriceVeriable = "$40.35";
// document.querySelector('.right-wrapper__flight-price-variable').textContent = flightPriceVeriable;

// Оголошення змінної taxesPriceVeriable
// var taxesPriceVeriable = "$18.13";
// document.querySelector('.right-wrapper__taxes-price-variable').textContent = taxesPriceVeriable;

// Оголошення змінної departureBagsVeriable
var departureBagsVeriable = "1";
document.querySelector('.right-wrapper__departure-bags-variable').textContent = departureBagsVeriable;

// Оголошення змінної returnBagsVeriable
var returnBagsVeriable = "1";
document.querySelector('.right-wrapper__return-bags-variable').textContent = returnBagsVeriable;

// Оголошення змінної choicePriceVeriable
var choicePriceVeriable = "$0";
document.querySelector('.right-wrapper__choice-price-variable').textContent = choicePriceVeriable;

// Оголошення змінної totalPriceVeriable
// var totalPriceVeriable = "$116.95";
// document.querySelector('.right-wrapper__total-price-variable').textContent = totalPriceVeriable;


// ==========Змінні для блока lower-wrapper==========

// Використовуємо змінну departureCityVeriable для класу .departure-city
document.querySelector('.departure-city').textContent = departureCityVeriable;

// Використовуємо змінну arrivalCityVeriable для класу .arrival-city
document.querySelector('.arrival-city').textContent = arrivalCityVeriable;

// Використовуємо змінну arrivalCityVeriable для класу .return-city
document.querySelector('.return-city').textContent = arrivalCityVeriable;

// Використовуємо змінну arrivalCityVeriable для класу .return-city
document.querySelector('.return-arrival-city').textContent = returnArrivalCityVeriable;


// ==========Нижня секція lower-wrapper правий блок з місцями==========
// Зміна кольору місця пасажира з розкладки та
// дублювання обраного місця з рокладки до кнопки Passenger 1 злівого боку

// Отримати місце та контейнер для обраного місця
const seats = document.querySelectorAll('.seat'); // Збираємо всі елементи місць
const selectedSeatsContainer = document.getElementById('selected-seat'); // Контейнер для дублювання
let selectedSeat = null; // Для збереження вибраного місця

// Додати слухачі до місць
seats.forEach((seat) => {
    seat.addEventListener('click', () => {
        const status = seat.getAttribute('data-status'); // Отримуємо статус місця
        const seatNumber = seat.textContent; // Отримуємо текст місця

        if (status === 'available') {
            // Якщо вже вибрано місце, скасувати вибір попереднього
            if (selectedSeat) {
                selectedSeat.setAttribute('data-status', 'available');
                const seatToRemove = selectedSeatsContainer.querySelector(
                    `.seat[data-seat-number="${selectedSeat.getAttribute('data-seat-number')}"]`
                );
                if (seatToRemove) {
                    seatToRemove.remove();
                }
            }

            // Встановити статус "selected" для нового місця
            seat.setAttribute('data-status', 'selected');

            // Видалити всі попередні дублікати в контейнері
            const allClones = selectedSeatsContainer.querySelectorAll('.seat');
            allClones.forEach(clone => {
                clone.remove(); // Видаляємо всі існуючі дублікати
            });

            const seatClone = document.createElement('div');
            seatClone.className = 'seat';
            seatClone.textContent = seatNumber;
            seatClone.classList.add('selected-seat');

            // Оновлення стилів (для синього кольору)
            seatClone.style.backgroundColor = 'blue';
            seatClone.style.color = 'white';

            // Додаємо нову копію місця в контейнер
            selectedSeatsContainer.appendChild(seatClone);

            // Оновлюємо вибране місце
            selectedSeat = seat;
        }
    });
});

// ==========Четверта секція, блок оплати==========
// Управління кнопками оплати
// Отримуємо всі кнопки
const buttons = document.querySelectorAll('.payment-button');

// Забезпечуємо, що жодна кнопка не буде "активною" спочатку
buttons.forEach((btn) => btn.classList.remove('active'));

// Додаємо обробник кліку для кожної кнопки
buttons.forEach((button) => {
    button.addEventListener('click', () => {
        // Знімаємо активний клас з усіх кнопок
        buttons.forEach((btn) => btn.classList.remove('active'));

        // Додаємо активний клас лише до натиснутої кнопки
        button.classList.add('active');
    });
});


// ==========Дії для медіа-запиту max-width: 360px==========
// Показуємо/ховаємо меню для малих екранів
document.addEventListener('DOMContentLoaded', function () {
    const toggleButton = document.querySelector('.nav-menu__toggle');
    const menuList = document.querySelector('.nav-menu__list');

    if (toggleButton && menuList) {
        toggleButton.addEventListener('click', function (event) {
            event.stopPropagation(); // Зупиняє поширення події, щоб клік по кнопці не закривав меню
            menuList.classList.toggle('show'); // Показуємо/ховаємо меню
        });

        // Закрити меню при кліку поза ним
        document.addEventListener('click', function (event) {
            if (!menuList.contains(event.target) && !toggleButton.contains(event.target)) {
                menuList.classList.remove('show'); // Ховаємо меню, якщо клік поза меню
            }
        });
    }
});