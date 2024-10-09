<!DOCTYPE html>
<html lang="ru">
<head>
  <meta charset="UTF-8"></meta>
  <style>
    h1 {
      color: #ccc;
    }
  </style>
</head>
<body>
  <h1>Бронирование номера в отеле ${hotelName}</h1>

  <p>Уважаемый ${guestSurname} ${guestFirstname},</p>

  <p>Мы рады подтвердить ваше бронирование номера в нашем отеле.</p>

  <p><strong>Детали бронирования:</strong></p>

  <ul>
    <li><strong>Дата бронирования:</strong> ${bookingDate}</li>
    <li><strong>Дата заезда:</strong> ${checkInDate}</li>
    <li><strong>Дата выезда:</strong> ${checkOutDate}</li>
    <li><strong>Количество гостей:</strong> ${countGuests}</li>
    <li><strong>Тип оплаты:</strong> ${typePayment}</li>
    <li><strong>Тип питания:</strong> ${typeFood}</li>
  </ul>

  <p>Мы с нетерпением ждем вас в ${hotelName}!</p>

  <p>С уважением,</p>

  <p>Команда ${hotelName}</p>

  <p> По всем вопросам обращаться по телефону ${hotelPhoneNumber} или пишите нам на почту ${hotelEmail}</p>

</body>