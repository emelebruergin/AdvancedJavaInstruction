package generics.classes;


    // BİRDEN FAZLA REFERANS DATA TİPİNİ ALAN GENERİC CLASS İ NASIL OLUSTURURUZ
    public class GenericClassTwoParametre <S,U> {


    //2 tane field olsun farklı data tiplerini referans alabilsin

        private S field;
        private U type;

        public S getField() {
            return field;
        }

        public void setField(S field) {
            this.field = field;
        }

        public U getType() {
            return type;
        }

        public void setType(U type) {
            this.type = type;
        }
    }
