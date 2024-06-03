import discord, logging, os, signal, subprocess
from discord.ext import commands
logging.basicConfig(level=logging.INFO,
                    format='%(asctime)s - %(name)s - %(levelname)s - %(message)s',
                    datefmt='%Y-%m-%d %H:%M:%S')
log = logging.getLogger(__name__)

jar_process = None

botintents = discord.Intents.default()
bot = commands.Bot(intents=botintents, command_prefix="/")

@bot.event
async def on_ready():
    log.info("Bot ready!")

@bot.tree.command(name="reboot", description="Restarts SemicolonBot in case it crashes")
async def reboot(interaction: discord.Interaction):
    send = interaction.response
    global jar_process

    if interaction.user.id != 554311851274534922:
        await send("No premissions, you need to be <@554311851274534922>")

    if jar_process is not None and jar_process.poll() is None:
        os.kill(jar_process.pid, signal.SIGTERM)
        jar_process = None
        await send('JAR file stopped.')
    else:
        if jar_process is None or jar_process.poll() is not None:
            jar_process = subprocess.Popen(['java', '-jar', 'path/to/yourfile.jar'])
            await send('Bot restarted')
        else:
            await send('Bot is already running')

bot.start(token="MTI0MzY3ODA2NjA0NDE3NDQ1Nw.GrICac.c7WhpFdOmdK7uY85EYSdU7o64Zy9OyUwo83EUw")