import uos, machine, gc, network, time
import gc
gc.collect() #Garbage Collector

wifi = network.WLAN(network.STA_IF)
acesspoint = network.WLAN(network.AP_IF)
wifi.active(True) #ativar estação (conectar roteador)
acesspoint.active(False) #desativar ponto de acesso

def do_connect(ssid, psw): #Função para conectar o WIFI
    if not wifi.isconnected():
        print('\nConectando à rede ...')
        wifi.connect(ssid, psw)
        time.sleep(10)
        if wifi.isconnected():
            print('\nConectado à rede ' + ssid)
        else:
            return print('\nNão foi possível conectar à rede')
    else:
        print('\nJá conectado à rede')
       
def net_config(): #Verificar a configuração do dispositivo na rede
    if (wifi.isconnected()):
        print('\nConfiguração da rede:', wifi.ifconfig())
    else:
        print('\nDispositivo não conectado à rede')
