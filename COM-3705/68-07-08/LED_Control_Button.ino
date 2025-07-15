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
