`LED_Control_Serial.ino`<br>
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
`main.ino`<br>
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
