package com.example.smartlearn

object  Constants   {
    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTION: String = "total_question"
    const val CORRECT_ANSWERS: String = "correct_answers"
    fun getQuestions():ArrayList<Questions>{
        val quesList=ArrayList<Questions>()
        val ques1=Questions(1,"Kotlin is developed by?",
                "Google",
                "JetBrains",
                "Microsoft",
                "Adode",
                2)
        quesList.add(ques1)

        val ques2=Questions(2,"Which of following is used to handle null exceptions in kotlin?",
                "Range",
                "Sealed Class",
                "Elvis Operator",
                "Lambda Function",
                3)
        quesList.add(ques2)

        val ques3=Questions(3,"Which file extension is used to save kotlin files.",
                ".java",
                ".kot",
                ".kt or kts",
                ".android",
                3)
        quesList.add(ques3)

        val ques4=Questions(4,"All classes in kotlin classes are by default?",
                "public",
                "final",
                "sealed",
                "abstract",
                2)
        quesList.add(ques4)

        val ques5=Questions(5,".Net CLR is not supported by kotlin.",
                "//",
                "/**/",
                "/*",
                "/multi line comment/",
                4)
        quesList.add(ques5)

        val ques6=Questions(6,"Which of the following is not the basic data types in kotlin?",
                "Numbers",
                "Strings",
                "Arrays",
                "Lists",
                4)
        quesList.add(ques6)

        val ques7=Questions(7,"Which of follwing targets currently not supported kotlin?",
                "LLVM",
                ".NET CLR",
                "javascript",
                "jvm",
                2)
        quesList.add(ques7)

        val ques8=Questions(8,"Kotlin was developed under the _______ license.",
                "Apache 1.0",
                "Apache 2.0",
                "Apache 1.1",
                "none of the above",
                2)
        quesList.add(ques8)

        val ques9=Questions(9,"W⁬hich of the followings constructors are availables in kotlin?",
                "Primary constructor",
                "Secondary constructor",
                "Both 1 & 2",
                "None of the above",
                3)
        quesList.add(ques9)

        val ques10=Questions(10,"Which of the following extension methods are used in kotlin?",
                "Read texts() & Headlines()",
                "Buffer reader()",
                "Read each line()",
                "All of the above",
                4)
        quesList.add(ques10)

        return quesList
    }
}