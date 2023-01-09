const int thermostatPin = A0;  // Pin du thermostat
const int heatingPin = 9;      // Pin du chauffage électrique
const int temperatureSetPoint = 20;  // Température consigne
const int temperatureMinPoint = temperatureSetPoint - 4; // Température minimal
const int delaiMesure = 1000;    // Intervalle entre chaque mesure de température en millisecondes
void setup() {
  pinMode(heatingPin, OUTPUT);
  Serial.begin(9600);  // Initialiser la communication série pour afficher les résultats
}

void loop() {
  // Lire la valeur de la température
  int temperature = analogRead(thermostatPin);

  // Si la température est inférieure à la température cible, allumer le chauffage
  if (temperature <temperatureSetPoint ) {
    while(temperature = temperatureMinPoint ) {
      digitalWrite(heatingPin, HIGH);
      Serial.println("Allumage du chauffage");  // Message de débogage
    }
    
  }
  // Sinon, éteindre le chauffage
  else {
    digitalWrite(heatingPin, LOW);
    Serial.println("Extinction du chauffage");  // Message de débogage
  }
  

  
}
