`Lab-1.ino`<br>
Create: 29 ก.ค. 2568 time 15:24<br>
Last edited: Time 16:07<br>

```ino

#define LED_1 D1  // Green
#define LED_2 D2  // Yellow
#define LED_3 D3  // Red

void flashLED(int ledPin, const char* ledName, int count) {
  for (int i = 1; i <= count; i++) {
    Serial.print(ledName);
    Serial.print(":");
    Serial.println(i);
    digitalWrite(ledPin, HIGH);
    delay(150);
    digitalWrite(ledPin, LOW);
    delay(150);
  }
}

void setup() {
  Serial.begin(9600); 
  pinMode(LED_1, OUTPUT); 
  pinMode(LED_2, OUTPUT);
  pinMode(LED_3, OUTPUT);
}

void loop() {
  flashLED(LED_1, "LED-RED", 3);  
  flashLED(LED_2, "LED-GREEN", 3); 
  flashLED(LED_3, "LED-YELLOW", 3); 
}
```
`Lab-2.ino`<br>
Create: 29 ก.ค. 2568 time 15:24<br>
Last edited: Time 15:58<br>

```ino
const int LED_1 = D1;
const int LED_2 = D2;
const int LED_3 = D3;
const int Button_Pin_1 = D4;

int ledPins[] = { LED_1, LED_2, LED_3 };

int currentLED = 0;
bool lastButtonState = LOW;

void setup() {
  pinMode(LED_1, OUTPUT);
  pinMode(LED_2, OUTPUT);
  pinMode(LED_3, OUTPUT);
  pinMode(Button_Pin_1, INPUT_PULLUP);

  Serial.begin(9600);
}

void loop() {
  int reading = digitalRead(Button_Pin_1);

  if (reading == LOW && lastButtonState == HIGH) {
    currentLED++;

    if (currentLED > 2) {
      currentLED = 0;
    }
  }

  lastButtonState = reading;

  if (currentLED == 0) {
    Serial.print("Red");
  } else if (currentLED == 1) {
    Serial.print("Yellow");
  } else {
    Serial.print("Green");
  }

  Serial.println(" LED is blinking.");

  digitalWrite(ledPins[currentLED], HIGH);
  delay(150);
  digitalWrite(ledPins[currentLED], LOW);
  delay(150);
}
```
