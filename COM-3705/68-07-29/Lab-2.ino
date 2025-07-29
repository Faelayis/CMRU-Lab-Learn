const int LED_1 = D1;
const int LED_2 = D2;
const int LED_3 = D3;
const int Button_Pin_1 = D4;

int ledPins[] = { LED_1, LED_2, LED_3 };

int currentLED = 0;
bool lastButtonState = LOW;
unsigned long lastDebounceTime = 0;
unsigned long debounceDelay = 50;

void setup() {
  pinMode(LED_1, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(LED_3, OUTPUT);
  pinMode(Button_Pin_1, INPUT_PULLUP);

  Serial.begin(9600);
}

void loop() {
  int reading = digitalRead(Button_Pin_1);

  if (reading == LOW && lastButtonState == HIGH && (millis() - lastDebounceTime) > debounceDelay) {
    lastDebounceTime = millis();
    currentLED++;
    if (currentLED > 2) currentLED = 0;
  }

  lastButtonState = reading;

  Serial.print("Now the ");

  if (currentLED == 0) {
    Serial.print("Red");
  } else if (currentLED == 1) {
    Serial.print("Yellow");
  } else {
    Serial.print("Green");
  }
  Serial.println(" LED is blinking.");

  digitalWrite(ledPins[currentLED], HIGH);
  delay(300);
  digitalWrite(ledPins[currentLED], LOW);
  delay(300);
}