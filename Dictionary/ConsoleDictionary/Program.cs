using System.Collections.Generic;

namespace ConsoleDictionary {

    class Program {
        public class Client {
            public string Name { get; set; }
            public int BirthYear { get; set; }

            public Client()
            {
                    
            }

            public Client(string name)
            {
                Name = name;
            }

            public override int GetHashCode()
            {
                return Name.GetHashCode();
            }

            public override bool Equals(object? obj)
            {
                if (obj == null) return false;

                return ((Client)obj).Name == Name;
            }
        }



        static void Main(string[] args)
        {

            Dictionary<int, Client> clients = new Dictionary<int, Client>();
            List<int> clientsToRemove = new List<int>();

            //Add
            clients.Add(1, new Client {  Name = "Mary", BirthYear = DateTime.Now.AddYears(-18).Year,  });
            clients.Add(2, new Client { Name = "John", BirthYear = DateTime.Now.AddYears(-12).Year, });

            //Compare with null object
            clients[1].Equals(null);

            //Check for key
            if (clients.ContainsKey(1))
                Console.WriteLine("Key fouded");

            //Check for value
            if (clients.ContainsValue(new Client("Mary")))
            {
                Console.WriteLine("Value founded");
            }


            foreach (KeyValuePair<int, Client> pair in clients)
            {
                Console.WriteLine("{0} born in {1}", pair.Value.Name, pair.Value.BirthYear);

                if (pair.Value.BirthYear > DateTime.Now.AddYears(-18).Year) 
                    clientsToRemove.Add(pair.Key);
            }

            foreach (int key in clientsToRemove)
            {
                Console.WriteLine("Removing client under 16: {0}", clients[key].Name);

                clients.Remove(key);
            }


        }
     }
}
