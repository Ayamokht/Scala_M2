# 📊 Scala Spark Data Pipeline – Template MoSEF

Ce projet est une **template ** développée en Scala avec Apache Spark.  
Il permet de lire des fichiers de données, d’appliquer des traitements sur les données en entrée, et d’enregistrer les résultats de façon automatisée.

---

## 🎯 Objectif:

- 📥 Lire des fichiers `.csv`, `.parquet` ou des tables Hive
- 🔍 Appliquer plusieurs transformations, 
- 📤 Écrire les résultats au format `.csv`, `.parquet` ou `.json` (configurable)

Ce template a été utilisé pour traiter un jeu de données de crédits, afin d'extraire des insights utiles comme :
- Le nombre de crédits par marque (`report1`)
- La distribution des sous-catégories par type de crédit (`report2`)
- Les crédits à risque toxique (`report3`)

---

## 🧱 Structure du projet
```text
src/ ├── main/ │ ├── scala/ │ │ └── fr/mosef/scala/template/ │ │ ├── Main.scala # point d’entrée │ │ ├── reader/ # lecture fichiers │ │ ├── writer/ # écriture résultats │ │ └── processor/ # traitements personnalisés │ └── resources/ │ └── configuration.properties ✅ # format de sortie intégré

```

> 📁 Le fichier `configuration.properties` est **intégré dans le `.jar`**, aucun fichier externe n’est requis à l’exécution.

---

## ▶️ Exécution du projet

### 📥 1. Télécharger le `.jar`

Clique ici pour télécharger :
👉 [`scala-project-1.4-jar-with-dependencies.jar`](https://github.com/Ayamokht/Scala_M2/packages/2465043)

### 📁 2. Télécharger les données

Place dans ton dossier `Downloads` :
- le fichier `credits.csv` **ou**
- le fichier `credits.parquet` pour tester 

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
