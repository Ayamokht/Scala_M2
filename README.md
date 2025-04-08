# 📊 Scala Spark Data Pipeline – Template MoSEF

---

## 🎯 Objectif:

- 📥 Lire des fichiers `.csv`, `.parquet` ou des tables Hive
- 🔍 Appliquer plusieurs transformations sur les données en entrée 
- 📤 Exporter les résultats dans un dossier `Outputs`


Ce template a été utilisé pour traiter un jeu de données de crédits, afin d'extraire des insights utiles comme :
- Le montant de crédit par client (`report1`)
- Date du premier crédit par client (`report2`)
- Montant moyen de crédit par type de crédit (`report3`)

---

## 🗂️ Structure du projet

```bash
.
├── data/                         # Données source
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

```

### ⚙️ Configuration de l'application

> 📁 Le fichier `configuration.properties` est **déjà intégré dans le `.jar`**.  
> **Aucun fichier externe n’est requis** pour exécuter l’application. Cependant, si vous souhaitez personnaliser les paramètres (format, séparateur, header, etc.), **vous avez 2 options** :

---

#### 🛠️ Méthode 1 – Modifier la configuration interne (dans le `.jar`)

1. Modifier le fichier : src/main/resources/configuration.properties
2. Recompiler le projet pour générer un nouveau `.jar` :
```bash
mvn clean package
```
#### 🛠️ Méthode 2 – Télécharger le fichier de configuration `.properties`
Accéder au dossier [resources](https://github.com/Ayamokht/Scala_M2/tree/main/src/main/resources) pour récupérer le fichier `configuration.properties`
---

## ▶️ Exécution du projet

### 📥 1. Télécharger le `.jar`

Clique ici pour télécharger :
👉 [`scala-project-1.5.1-jar-with-dependencies.jar`](https://github.com/Ayamokht/Scala_M2/packages/2465043)

### 📁 2. Télécharger les données et le fichier de configuration `.properties`

📥 **Téléchargement des données** :  
Accéder au dossier [data](https://github.com/Ayamokht/Scala_M2/tree/main/data) du dépôt GitHub pour récupérer :
- le fichier `credits.csv` **ou**
- le fichier `credits.parquet` (pour tester avec le format Parquet)

### 💻 3. Ouvrir un terminal dans le dossier `Downloads`

** Sur Linux/MacOS**
```bash
cd ~/Downloads
```
** Sur Windows**
```bash
cd %USERPROFILE%\Downloads
```

** Ensuite lancer cette ligne de commande **
```bash
java -jar scala-project-1.5.1-jar-with-dependencies.jar "local[*]" "credits.parquet" Outputs report1,report2,report3
```
