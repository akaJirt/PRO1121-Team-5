# PRO1121-Team-5
Bảng user:
-          PK userId
-          username
-          password
-          fullName
-          phoneNumber
-          email
-          role
-          address
Bảng hotel
-          PK hotelId
-          FK userId
-          hotelName
-          address
-          rate
Bảng bill:
-          PK billId
-          FK idUser
-          FK roomId
-          checkInDate
-          checkOutDate
-          payMentMethod
-          ratingAndComment
Bảng room
-          PK roomId
-          FK hotelId
-          type
-          price
-          status
-          capacity
