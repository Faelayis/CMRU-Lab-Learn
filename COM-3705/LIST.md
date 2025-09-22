
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


## 68-07-29

##### `Lab-1.ino`<br>
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

##### `Lab-2.ino`<br>
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


## 68-08-15

##### `dhp.ino`<br>
Create: 22 ส.ค. 2568 time 08:34<br>
```ino
#include <DHT.h>

#define DHTPIN D4   
#define DHTTYPE DHT11  

DHT dht(DHTPIN, DHTTYPE);

void setup() {
  Serial.begin(9600);
  dht.begin();
}

void loop() {
  delay(2000);

  float h = dht.readHumidity();
  float tC = dht.readTemperature();
  float tF = dht.readTemperature(true);

  if (isnan(h) || isnan(tC)) {
    return;
  }

  Serial.print(F("Humidity: "));
  Serial.print(h);
  Serial.print(F(" %  Temperature: "));
  Serial.print(tC);
  Serial.print(F(" C ("));
  Serial.print(tF);
  Serial.println(F(" F)"));
}
```


## 68-09-16

##### `index.ino`<br>
Create: 22 ก.ย. 2568 time 16:49<br>
```ino
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

const char* ssid = "@CMRU-SCI";
const char* password = "";

const char* serverBase = "http://10.80.101.14:3000/";
const int LDR_PIN = A0;   
const int RAIN_SENSOR_PIN = D2;

WiFiClient wifiClient;
HTTPClient http;

void setup() {
  Serial.begin(9600);
  pinMode(RAIN_SENSOR_PIN, INPUT);
  WiFi.begin(ssid, password);

  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.println("Connecting to WiFi...");
  }
  Serial.println("Connected to WiFi");
  Serial.print("IP address: ");
  Serial.println(WiFi.localIP());
}

void loop() {
  if (WiFi.status() == WL_CONNECTED) {
    int ldrValue = analogRead(LDR_PIN);
    int rainSensorValue = digitalRead(RAIN_SENSOR_PIN);
    
    String rainStatus = (rainSensorValue == HIGH) ? "dry" : "wet";
    String rainfall = "25mm";
    String serverURL = String(serverBase) + "?rainfall=" + rainfall + 
                      "&ldr_reading=" + String(ldrValue) + 
                      "&rain_sensor_status=" + rainStatus;
    
    Serial.println("=== Sensor Readings ===");
    Serial.println("Rainfall: " + rainfall);
    Serial.println("LDR Reading: " + String(ldrValue));
    Serial.println("Rain Sensor Status: " + rainStatus);
    Serial.println("Request URL: " + serverURL);
    
    http.begin(wifiClient, serverURL);
    int httpCode = http.GET(); 

    if (httpCode > 0) {
      Serial.printf("HTTP Response code: %d\n", httpCode);
      String payload = http.getString();
      Serial.println("Response: " + payload);
    } else {
      Serial.printf("HTTP Request failed, error: %s\n", http.errorToString(httpCode).c_str());
    }

    http.end();
  } else {
    Serial.println("WiFi not connected");
  }

  delay(5000); 
}

```
