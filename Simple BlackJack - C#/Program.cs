using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace BlackJack
{
    class User
    {
        public int points { get; set; }
        public String name { get; set; }
    }

    class Game {

        public void play(User player, User dealer)
        {
            //Intiliaze points to 0.
            dealer.name = "Dealer";
            player.name = "You";
            dealer.points = 0;
            player.points = 0;


            // Gives player two cards.
            Console.WriteLine(hit(player));
            Console.WriteLine(hit(player));
            Console.WriteLine("\nWould you like to hit or stay? h/s");

            // Ask player for input to hit or stay.
            char input = Console.ReadKey().KeyChar;

            if (input == 'h')
            {
                while (player.points <= 21 && input == 'h')
                {
                    Console.WriteLine(hit(player));
                    if (player.points > 22) break;

                    input = Console.ReadKey().KeyChar;
                }

                if (player.points > 21) {
                    Console.WriteLine("\nYou loose. Points are over 21, your points : " + player.points);
                }

            }

            if (input == 's')
            {
                while (dealer.points <= 17)
                {
                    Console.WriteLine(hit(dealer));
                }


                if (dealer.points >= player.points && dealer.points <= 21)
                {
                    Console.WriteLine("\nDealer wins. (Your total was : " + player.points + " and dealer was : " + dealer.points + " )");
                }

                if (dealer.points < player.points && player.points <=21) {
                    Console.WriteLine("\nYou win. (Your total was : " + player.points + " and dealer was : " + dealer.points + " )");
                }
            }
        }

        // Creates a new card and adds it to users sum. Prints out card and current total sum.
        public String hit(User user)
        {
            // Creates a random number and assigns this value to a card.
            var randomNumberGenerator = new Random();
            int cardValue = randomNumberGenerator.Next(13, 15);
            Card cad = (Card)cardValue;

            //Counts points of the card.
            switch (cardValue) {
                case 1:
                    user.points += 1;
                    break;
                case 2:
                    user.points += 2;
                    break;
                case 3:
                    user.points += 3;
                    break;
                case 4:
                    user.points += 4;
                    break;
                case 5:
                    user.points += 5;
                    break;
                case 6:
                    user.points += 6;
                    break;
                case 7:
                    user.points += 7;
                    break;
                case 8:
                    user.points += 8;
                    break;
                case 9:
                    user.points += 9;
                    break;
                case 10:
                    user.points += 10;
                    break;
                case 11:
                    user.points += 10;
                    break;
                case 12:
                    user.points += 10;
                    break;
                case 13:
                    user.points += 10;
                    break;
                case 14:
                    user.points += 10;
                    if (user.points > 21)
                    {user.points -= 9;}
                    break;
            }

            String update = user.name + " pulled " + cad + " from the deck. " + user.name + " total sum is " + user.points + ". ";
            return update;
        }

    }

   public enum Card{
        One = 1,
        Two = 2,
        Three = 3,
        Four = 4,
        Five = 5,
        Six = 6,
        Seven = 7,
        Eight = 8,
        Nine = 9,
        Ten = 10,
        Knekt = 11,
        Queen = 12,
        King = 13,
        Ace = 14
    }


    class Program
    {
        static void Main(string[] args)
        {
            Game g = new Game();
            User player = new User();
            User dealer = new User();
            g.play(player, dealer);

            Console.WriteLine("\nWould you like to play again? Yes or no. y / n");
            char input = Console.ReadKey().KeyChar;

            while (input == 'y') {
                Game g2 = new Game();
                User player2 = new User();
                User dealer2 = new User();
                g2.play(player2, dealer2);

                Console.WriteLine("\nWould you like to play again? Yes or no. y / n");
                input = Console.ReadKey().KeyChar;
            }

        }
    }
}
