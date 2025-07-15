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