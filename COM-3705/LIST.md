
## 68-07-08

##### `LED_Control_Button.ino`<br>
Create: 15 ก.ค. 2568 time 17:20<br>
```ino
#define LED_1 D1
#define LED_2 D2

#define Button_Pin_1 D5
#define Button_FLASH D3

 
bool ledState = LOW;
bool lastButtonState = HIGH;
bool lastFlashButtonState = HIGH;

bool loopLED = false;

void setup() {
  pinMode(LED_1, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(Button_Pin_1, INPUT_PULLUP);
  pinMode(Button_FLASH, INPUT_PULLUP);

  digitalWrite(LED_1, ledState);
  digitalWrite(LED_2, LOW);
}

void loop() {
  bool currentButtonState = digitalRead(Button_Pin_1);
  bool currentFlashButtonState = digitalRead(Button_FLASH);

  if (!loopLED && lastButtonState == HIGH && currentButtonState == LOW) {
    ledState = !ledState;

    digitalWrite(LED_1, ledState);
    delay(50);
  }
  lastButtonState = currentButtonState;

  if (lastFlashButtonState == HIGH && currentFlashButtonState == LOW) {
    loopLED = !loopLED;

    if (!loopLED) {
      digitalWrite(LED_2, LOW);
      digitalWrite(LED_1, ledState);
    }
  }

  lastFlashButtonState = currentFlashButtonState;

  if (loopLED) {
      digitalWrite(D0, HIGH);
    digitalWrite(LED_1, HIGH);
    digitalWrite(LED_2, LOW);
    delay(20);
    digitalWrite(LED_1, LOW);
    digitalWrite(LED_2, HIGH);
    delay(20);
  } else {
    digitalWrite(LED_1, HIGH);
    digitalWrite(LED_2, HIGH);
  }
}

```


## 68-07-15

##### `LED_Control_Serial.ino`<br>
Create: 15 ก.ค. 2568 time 17:20<br>
```ino
#define LED_1 D1  // Green
#define LED_2 D2  // Yellow
#define LED_3 D3  // Red

void setup() {
  pinMode(LED_1, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(LED_3, OUTPUT);

  Serial.begin(9600);
  Serial.println("Hello Arduino");

  digitalWrite(LED_1, LOW);
  digitalWrite(LED_2, LOW);
  digitalWrite(LED_3, LOW);
}

void loop() {

  if (Serial.available() > 0) {

    char key = Serial.read();

    Serial.print("Received key: ");
    Serial.println(key);

    switch (key) {
      case '0':
        digitalWrite(LED_1, LOW);
        digitalWrite(LED_2, LOW);
        digitalWrite(LED_3, LOW);
        Serial.println("All LEDs OFF");
        break;

      case '1':
        digitalWrite(LED_1, HIGH);
        digitalWrite(LED_2, HIGH);
        digitalWrite(LED_3, HIGH);
        Serial.println("All LEDs ON");
        break;

      default:
        break;
    }
  }
}
```

##### `main.ino`<br>
Create: 15 ก.ค. 2568 time 17:20<br>
```ino
#define LED_1 D1  // Green
#define LED_2 D2  // Yellow
#define LED_3 D3  // Red

void setup() {
  pinMode(LED_1, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(LED_3, OUTPUT);

  digitalWrite(LED_1, LOW);
  digitalWrite(LED_2, LOW);
  digitalWrite(LED_3, LOW);
}

void loop() {
  digitalWrite(LED_2, HIGH);
  digitalWrite(LED_1, LOW);

  delay(500);

  digitalWrite(LED_2, LOW);
  digitalWrite(LED_1, HIGH);

  delay(500);
}
```
