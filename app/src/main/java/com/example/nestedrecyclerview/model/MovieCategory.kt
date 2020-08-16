package com.example.nestedrecyclerview.model

data class MovieCategory(
        val id: Int,
        val type: MovieType,
        val movies: List<Movie>
)

enum class MovieType {
    ACTION, DRAMA, ADVENTURE
}

fun getDummyData() =
        listOf(
                MovieCategory(
                        1,
                        MovieType.ACTION,
                        listOf(
                                Movie(1, "Money Heist", "An unusual group of robbers attempt to carry out the most perfect robbery in Spanish history - stealing 2.4 billion euros from the Royal Mint of Spain.", "https://m.media-amazon.com/images/M/MV5BZDcxOGI0MDYtNTc5NS00NDUzLWFkOTItNDIxZjI0OTllNTljXkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_UX182_CR0,0,182,268_AL_.jpg"),
                                Movie(2, "Tenet", "Armed with only one word, Tenet, and fighting for the survival of the entire world, a Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time.", "https://m.media-amazon.com/images/M/MV5BOGJmZjcxNTAtYjViZS00YzJmLTlkMzgtZmVkYTQ5YjUwMjIyXkEyXkFqcGdeQXVyNjMwMzc3MjE@._V1_UX182_CR0,0,182,268_AL_.jpg"),
                                Movie(3, "Avengers: Endgame", "After the devastating events of Avengers: Infinity War (2018), the universe is in ruins. With the help of remaining allies, the Avengers assemble once more in order to reverse Thanos' actions and restore balance to the universe.", "https://m.media-amazon.com/images/M/MV5BMTc5MDE2ODcwNV5BMl5BanBnXkFtZTgwMzI2NzQ2NzM@._V1_UX182_CR0,0,182,268_AL_.jpg"),
                                Movie(4, "Wonder Woman 1984", "Fast forward to the 1980s as Wonder Woman's next big screen adventure finds her facing two all-new foes: Max Lord and The Cheetah.", "https://m.media-amazon.com/images/M/MV5BZGVhZDBlZjgtMGNmNi00OTIyLWI1NzQtMzE5ZWQ0NzFmMjg0XkEyXkFqcGdeQXVyMTA2OTQ3MTUy._V1_UX182_CR0,0,182,268_AL_.jpg")
                        )),
                MovieCategory(
                        1,
                        MovieType.DRAMA,
                        listOf(
                                Movie(1, "Yellowstone", "A ranching family in Montana faces off against others encroaching on their land.", "https://m.media-amazon.com/images/M/MV5BZjhkNWM1NTQtODI4NS00NzllLTg1ODAtYjg3N2QxZjc3ZjRiXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_UY268_CR8,0,182,268_AL_.jpg"),
                                Movie(2, "Game of Thrones", "Nine noble families fight for control over the lands of Westeros, while an ancient enemy returns after being dormant for millennia.", "https://m.media-amazon.com/images/M/MV5BYTRiNDQwYzAtMzVlZS00NTI5LWJjYjUtMzkwNTUzMWMxZTllXkEyXkFqcGdeQXVyNDIzMzcwNjc@._V1_UY268_CR7,0,182,268_AL_.jpg"),
                                Movie(3, "Jojo Rabbit", "A young boy in Hitler's army finds out his mother is hiding a Jewish girl in their home.", "https://m.media-amazon.com/images/M/MV5BZjU0Yzk2MzEtMjAzYy00MzY0LTg2YmItM2RkNzdkY2ZhN2JkXkEyXkFqcGdeQXVyNDg4NjY5OTQ@._V1_UX182_CR0,0,182,268_AL_.jpg"),
                                Movie(4, "Hamilton", "The real life of one of America's foremost founding fathers and first Secretary of the Treasury, Alexander Hamilton. Captured live on Broadway from the Richard Rodgers Theater with the original Broadway cast.", "https://m.media-amazon.com/images/M/MV5BNjViNWRjYWEtZTI0NC00N2E3LTk0NGQtMjY4NTM3OGNkZjY0XkEyXkFqcGdeQXVyMjUxMTY3ODM@._V1_UX182_CR0,0,182,268_AL_.jpg")
                        )),
                MovieCategory(
                        1,
                        MovieType.ADVENTURE,
                        listOf(
                                Movie(1, "Jurassic Park", "A pragmatic paleontologist visiting an almost complete theme park is tasked with protecting a couple of kids after a power failure causes the park's cloned dinosaurs to run loose", "https://m.media-amazon.com/images/M/MV5BMjM2MDgxMDg0Nl5BMl5BanBnXkFtZTgwNTM2OTM5NDE@._V1_UX182_CR0,0,182,268_AL_.jpg"),
                                Movie(2, "The Witcher", "Geralt of Rivia, a solitary monster hunter, struggles to find his place in a world where people often prove more wicked than beasts.", "https://m.media-amazon.com/images/M/MV5BOGE4MmVjMDgtMzIzYy00NjEwLWJlODMtMDI1MGY2ZDlhMzE2XkEyXkFqcGdeQXVyMzY0MTE3NzU@._V1_UX182_CR0,0,182,268_AL_.jpg"),
                                Movie(3, "Inception", "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.", "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@._V1_UX182_CR0,0,182,268_AL_.jpg"),
                                Movie(4, "Doctor Who", "The further adventures in time and space of the alien adventurer known as the Doctor and their companions from planet Earth.", "https://m.media-amazon.com/images/M/MV5BZWJhYjFmZDEtNTVlYy00NGExLWJhZWItNTAxODY5YTc3MDFmXkEyXkFqcGdeQXVyMTkxNjUyNQ@@._V1_UY268_CR4,0,182,268_AL_.jpg")
                        ))
        )