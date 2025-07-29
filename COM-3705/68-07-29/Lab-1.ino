
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