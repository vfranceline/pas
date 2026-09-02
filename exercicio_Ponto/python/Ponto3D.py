from Ponto import Ponto

class Ponto3D(Ponto):
    def __init__(self, x, y, z):
        super().__init__(x, y)
        self.__z = z

    @property
    def z(self):
        return self.__z

    @z.setter
    def z(self, value):
         self.__z = value