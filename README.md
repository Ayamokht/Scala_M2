# 📊 Scala Spark Data Pipeline – Template MoSEF

Ce projet est une **template ** développée en Scala avec Apache Spark.  
Il permet de lire des fichiers de données, d’appliquer des traitements sur les données en entrée, et d’enregistrer les résultats de façon automatisée.

---

## 🎯 Objectif:

- 📥 Lire des fichiers `.csv`, `.parquet` ou des tables Hive
- 🔍 Appliquer plusieurs transformations, 
- 📤 Exporter les résultats dans un dossier `Outputs`
- Utilise un fichier de configuration `.properties` interne (par défaut) ou externe (optionnel)


Ce template a été utilisé pour traiter un jeu de données de crédits, afin d'extraire des insights utiles comme :
- Le nombre de crédits par marque (`report1`)
- La distribution des sous-catégories par type de crédit (`report2`)
- Les crédits à risque toxique (`report3`)

---

## 🗂️ Structure du projet

```bash
.
├── data/                         # Données source (CSV ou Parquet)
│   ├── credits.csv
│   └── credits.parquet
│
├── Outputs/                      # Résultats générés
│   ├── report1/
│   ├── report2/
│   └── report3/
│
├── src/
│   └── main/
│       ├── resources/
│       │   ├── configuration.properties   # Config interne par défaut
│       │   └── test_file.csv
│       └── scala/
│           └── fr/
│               └── mosef/
│                   └── scala/
│                       └── template/
│                           ├── Main.scala
│                           ├── job/
│                           │   └── Job.scala
│                           ├── processor/
│                           │   ├── Processor.scala
│                           │   └── impl/ProcessorImpl.scala
│                           ├── reader/
│                           │   ├── Reader.scala
│                           │   └── impl/...
│                           └── writer/
│                               └── Writer.scala

> 📁 Le fichier `configuration.properties` est **intégré dans le `.jar`**, aucun fichier externe n’est requis à l’exécution.
```
---

## ▶️ Exécution du projet

### 📥 1. Télécharger le `.jar`

Clique ici pour télécharger :
👉 [`scala-project-1.4-jar-with-dependencies.jar`](https://github.com/Ayamokht/Scala_M2/packages/2465043)

### 📁 2. Télécharger les données et le fichier de configuration `.properties`

📥 **Téléchargement des données** :  
Accéder au dossier [data](https://github.com/Ayamokht/Scala_M2/tree/main/data) du dépôt GitHub pour récupérer :
- le fichier `credits.csv` **ou**
- le fichier `credits.parquet` (pour tester avec le format Parquet)

📥 **Téléchargement du fichier de configuration** :  
Accéder au dossier [resources](https://github.com/Ayamokht/Scala_M2/tree/main/src/main/resources) pour récupérer :
- le fichier `configuration.properties` 

### 💻 3. Ouvrir un terminal dans le dossier `Downloads`

```bash
cd ~/Downloads
```

```bash

java -jar scala-project-1.4-jar-with-dependencies.jar \
"local[*]" \
"credits.parquet" \
Outputs \
report1,report2, report3 \
"configuration.properties"

```
