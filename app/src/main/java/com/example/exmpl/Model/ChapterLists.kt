package com.example.exmpl.Model

class ChapterLists {
    companion object {
        fun getChaptersForClass(userClass: String?): List<Chapter> {
            return when (userClass) {
                "6" -> mutableListOf(
                    Chapter(1, "Food: Where Does It Come from?"),
                    Chapter(2, "Components of Food"),
                    Chapter(3, "Fibre to Fabric"),
                    Chapter(4, "Sorting Materials into Groups"),
                    Chapter(5, "Separation of Substances"),
                    Chapter(6, "Changes around Us"),
                    Chapter(7, "Getting to Know Plants"),
                    Chapter(8, "Body Movements")
                )
                "7" -> mutableListOf(
                    Chapter(1, "Nutrition in Plants"),
                    Chapter(2, "Nutrition in Animals"),
                    Chapter(3, "Fibre to Fabric"),
                    Chapter(4, "Heat"),
                    Chapter(5, "Acids, Bases, and Salts"),
                    Chapter(6, "Physical and Chemical Changes"),
                    Chapter(7, "Weather, Climate, and Adaptations of Animals to Climate"),
                    Chapter(8, "Winds, Storms, and Cyclones")
                )
                "8" -> mutableListOf(
                    Chapter(1, "Crop Production and Management"),
                    Chapter(2, "Microorganisms: Friend and Foe"),
                    Chapter(3, "Synthetic Fibres and Plastics"),
                    Chapter(4, "Materials: Metals and Non-Metals"),
                    Chapter(5, "Coal and Petroleum"),
                    Chapter(6, "Combustion and Flame"),
                    Chapter(7, "Conservation of Plants and Animals"),
                    Chapter(8, "Cell: Structure and Functions")
                )
                "9" -> mutableListOf(
                    Chapter(1, "Matter in Our Surroundings"),
                    Chapter(2, "Is Matter Around Us Pure?"),
                    Chapter(3, "Atoms and Molecules"),
                    Chapter(4, "Structure of the Atom"),
                    Chapter(5, "The Fundamental Unit of Life (Biology)"),
                    Chapter(6, "Tissues (Biology)"),
                    Chapter(7, "Diversity in Living Organisms (Biology)"),
                    Chapter(8, "Motion (Physics)")
                )
                "10" -> mutableListOf(
                    Chapter(1, "Chemical Reactions and Equations"),
                    Chapter(2, "Acids, Bases, and Salts"),
                    Chapter(3, "Metals and Non-Metals"),
                    Chapter(4, "Carbon and its Compounds"),
                    Chapter(5, "Periodic Classification of Elements"),
                    Chapter(6, "Life Processes (Biology)"),
                    Chapter(7, "Control and Coordination (Biology)"),
                    Chapter(8, "How do Organisms Reproduce? (Biology)")
                )
                else -> emptyList() // Handle other cases if needed
            }
        }
    }
}